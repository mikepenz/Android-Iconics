#!/bin/bash

OUTPUT_FONT_FILE=src/main/res/font/material_symbols_font.ttf
EDIT_KT_FILE=src/main/java/com/mikepenz/iconics/typeface/library/materialsymbols/OutlinedMaterialSymbols.kt

wget https://github.com/google/material-design-icons/raw/refs/heads/master/variablefont/MaterialSymbolsOutlined%5BFILL,GRAD,opsz,wght%5D.ttf \
  -O "${OUTPUT_FONT_FILE?}"

icon_names=$(wget https://github.com/google/material-design-icons/raw/refs/heads/master/variablefont/MaterialSymbolsOutlined%5BFILL,GRAD,opsz,wght%5D.codepoints -O -)

SPLIT_REGEXES=(
  ^[0-9a-l].*$
  ^[^0-9a-l].*$ # This is basically the range m-z.
)

for i in "${!SPLIT_REGEXES[@]}"; do
  lead="^.*BEGIN GENERATED CONTENT$((i+1))\$"
  tail="^.*END GENERATED CONTENT$((i+1))\$"
  split_regex="${SPLIT_REGEXES[$i]}"
  echo "${icon_names}" \
    | grep "${split_regex}" \
    | awk '{print "        mso_"$1"('\''\\u"$2"'\''),"}' \
    | sed -i -e "/$lead/,/$tail/{ /$lead/{p; r /dev/stdin
              }; /$tail/p; d }" \
      "${EDIT_KT_FILE?}"
done
