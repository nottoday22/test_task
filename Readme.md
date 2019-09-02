## Installation
First of all you must download next image:

docker pull azshoo/alaska

After image was installed, run this app with help next command:

run -d --name alaska -p 8091:8091 azshoo/alaska

Check was docker container started or not:

docker ps

##Running Tests

To run tests you should use Maven
First of all check is Maven installed on your pc:

mvn --version

Ok, we have maven and we can try to start out tests.

To run tests i prefer to use "profiles", there are 5 id profiles which will start tests:
1. DeleteRequests
2. PutRequests
3. PostRequests
4. GetRequests
5. AllTests

If you want to run them you should just write:

mvn test -P DeleteRequests
mvn test -P PostRequests
mvn test -P PutRequests
mvn test -P GetRequests
mvn test -P AllTests

That's all, thank you.