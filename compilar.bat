rmdir build /S /Q

mkdir build

dir /s /B "*.java" > sources.txt
javac -cp .;./src;./lib/mariadb-java-client-3.5.0.jar -d ./build @sources.txt

java -cp .;./build;./lib/mariadb-java-client-3.5.0.jar edu.curso.boundary.MainBoundary