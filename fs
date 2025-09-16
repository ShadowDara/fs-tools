#!/bin/bash

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

echo "Programm Requires Java 21"

LIB_DIR="$SCRIPT_DIR"

CLASSPATH="$LIB_DIR/fs-tools.jar"

java -cp "$CLASSPATH" de.shadowdara.fstools.Main "$@"
