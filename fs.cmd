@echo off

SET SCRIPT_DIR=%~dp0

ECHO Programm Requires Java 21

SET LIB_DIR=%SCRIPT_DIR%

SET CLASSPATH=%LIB_DIR%fs-tools.jar

djava -cp "%CLASSPATH%" de.shadowdara.fstools.Main %*
