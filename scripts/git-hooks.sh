#!/usr/bin/env bash

set -o errexit
set -o nounset
set -o pipefail
[ -n "${DEBUG+x}" ] && set -o xtrace

echo "git hooks"

if [ ! -L .git/hooks/commit-msg ]; then
  echo 'link .git/hooks/commit-msg'
  ln -s ../../githooks/commit-msg.sh .git/hooks/commit-msg
else
  echo 'link .git/hooks/commit-msg exists'
fi

if [ ! -L .git/hooks/verbs.txt ]; then
  echo 'link .git/hooks/verbs.txt'
  ln -s ../../githooks/verbs.txt .git/hooks/verbs.txt
else
  echo 'link .git/hooks/verbs.txt exists'
fi
