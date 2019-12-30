#!/bin/bash

echo "Writing keystore.properties"
echo ${KEYSTORE_PROPERTIES} > keystore.properties

writeKeystore() {
    echo "Writing $1.keystore"
    # command inside parenthesis converts  $1 to upper case
    input="$(echo "$1" | tr '[a-z]' '[A-Z]')_KEYSTORE"
    output="./keystores/$1.keystore"
    echo "${!input}" > ${output}
}

mkdir keystores
writeKeystore "dev"
writeKeystore "staging"
writeKeystore "prod"