#!/bin/bash

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

if [ "$#" -eq 1 ]; then # double brackets do not work in ubuntu 18.04
    writeKeystore $1
else
	writeKeystore "dev"
	writeKeystore "staging"
	writeKeystore "prod"
fi