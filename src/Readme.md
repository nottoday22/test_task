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

To run tests i prefer to use "profiles", there are 5 suites that u can run:
1. all_tests
2. delete_requests
3. get_requests
4. post_requests
5. put_requests

If you want to run them you should just write:

mvn test -P Delete_requests   (for example)

That's all, thank you.