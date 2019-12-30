#!/bin/sh

decrypt() {
    echo "Decrypt $1 google-services.json"
	# --batch to prevent interactive command --yes to assume "yes" for questions
	# Add GOOGLE_SERVICE_JSON_SECRET value to github secret for github actions
	# On your local machine, add GOOGLE_SERVICE_JSON_SECRET as an env variable
	gpg --quiet --batch --yes --decrypt \
	--passphrase="$GOOGLE_SERVICES_JSON_SECRET" \
	--output "./app/src/$1/google-services.json" \
	"./app/src/$1/google-services.json.gpg"
}

if [ "$#" -eq 1 ]; then # double brackets do not work in ubuntu 18.04
    decrypt $1
else
	decrypt "dev"
	decrypt "staging"
	decrypt "prod"
fi