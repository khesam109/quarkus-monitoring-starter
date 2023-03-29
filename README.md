
Generate key:

	openssl genrsa -des3 -out prometheus.key 2048

Generate csr:
openssl req -new -key prometheus.key -out prometheus.csr

Prepare a copy of prometheus.key and remove password:
openssl rsa -in "prometheus_copy.key" -out "prometheus.key"

Generate Certificate:
openssl x509 -req -in prometheus.csr -signkey prometheus.key -out  prometheus.crt -day 3650 -sha256 -extfile  prometheus.ext

prometheus.ext >>>>

subjectKeyIdentifier   = hash
authorityKeyIdentifier = keyid:always,issuer:always
basicConstraints       = CA:TRUE
keyUsage               = digitalSignature, nonRepudiation, keyEncipherment, dataEncipherment, keyAgreement, keyCertSign
subjectAltName         = DNS:prometheus, DNS:*.prometheus
issuerAltName          = issuer:copy
