#!/usr/bin/env bash

set -o errexit
set -o nounset
set -o pipefail
[ -n "${DEBUG+x}" ] && set -o xtrace

red='\033[0;31m'
green='\033[0;32m'
nc='\033[0m'

branch=$(git rev-parse --abbrev-ref HEAD)
type=$(head -n 1 "${1}" | cut -d ':' -f1)
verb=$(head -n 1 "${1}" | cut -d ':' -f2 | cut -d ' ' -f2)

error=

echo "Commit check"

if [[ "${branch}" =~ ^(feat|chore|docs|fix|refactor|style|test)/[a-z0-9\-]+$ ]]; then
  echo -e "${green}Branch name: OK${nc}"
else
  echo -e "${red}Branch name: ERROR"
  echo -e "${nc}Incorrect branch name (feat|chore|docs|fix|refactor|style|test)/description"
  error=true
fi

if [[ "${type}" =~ ^(feat|chore|docs|fix|refactor|style|test)(\([a-z0-9]+\)){0,1}$ ]]; then
  echo -e "${green}Semantic version type '${type}': OK${nc}"
else
  echo -e "${red}Semantic version type '${type}': ERROR"
  echo -e "${nc}Missing type in message feat|chore|docs|fix|refactor|style|test"
  error=true
fi

if grep -q "${verb}" .git/hooks/verbs.txt; then
  echo -e "${green}Semantic version verb '${verb}': OK${nc}"
else
  echo -e "${red}Semantic version verb '${verb}': ERROR"
  echo -e "${nc}Missing a verb in message"
  error=true
fi

if [ -n "${error}" ]; then
  exit 1
fi
