#asynchronous

non-blocking

trigger read operation and when it is done a callback is triggered

a single thread can handle many operations

threads have overhead

context switching has cost, pools help to alleviate this cost

- Selector
    1. create a channel
    1. config it to be non-blocking
    1. register channel with selector
    1. get the registration key
    
channel will fire events
- read, write
- connect
- accept

 
 
