@echo off
set /p sistema=Ingrese sistema actual:
set /p sistemaCambiar = Ingrese sistema cambiar:
E:
cd /
cd git
cd as2
cd ant
move build-wildfly.properties back%sistema%-build-wildfly.properties
move back%sistemaCambiar%-build-wildfly.properties build-wildfly.properties
