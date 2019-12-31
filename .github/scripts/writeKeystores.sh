#!/bin/bash

# Used to preserve line breaks.
# Without this everything in keystore.properties will be in one line when it's written
IFS=

echo "Write keystore.properties"
echo ${KEYSTORE_PROPERTIES} > keystore.properties

writeKeystore() {
    echo "Write $1.keystore"
    # command inside parenthesis converts  $1 to upper case
    input="$(echo "$1" | tr '[a-z]' '[A-Z]')_KEYSTORE"
    output="./keystores/$1.keystore"
    echo "${!input}" > ${output}
}

mkdir keystores

if [[ "$#" -eq 1 ]]; then
    writeKeystore $1
else
	writeKeystore "dev"
	writeKeystore "staging"
	writeKeystore "prod"
fi