### Prerequisites ###
Java 1.8
Chrome 60 64-bit
Windows 7 / 10
JAVA_HOME add to PATH
Adobe Flash Player

### Brief description ###
NewsTest, RadioTest and APITest which are located under /src/test/java/assessment address those three assessment sections respectively. There are 12 tests in NewsTest and RadioTest all together,
the first test of NewsTest addresses first 2 section A assignments, the rest are one on one.

### Tests running instructions ###
The last test of RadioTest requires Adobe Flash Player and Chrome needs to allow Flash on ABC sites. Following post has good instructions on this http://www.online-tech-tips.com/google-softwaretips/enable-flash-chrome-specific-websites/.
The project has been run successfully by two means:
1. Load the project in IntelliJ IDEA and run the three test files under individually.
2. Run "mvn clean test" and "mvn -Dtest=classname test" and "mvn -Dtest=classname#testname test" in Git Bash. Can follow this link to make Maven and Git Bash ready:
https://shivabalachandran.wordpress.com/2015/08/11/setting-up-java-maven-and-git-on-windows-7/.
