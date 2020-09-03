find . -name "*.class" -delete
find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java root.Main root/scenario.txt

