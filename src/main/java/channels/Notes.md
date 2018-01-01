#Channels

- Buffer: where the data resides
- Channel: where the data comes from
- Selector: handles asynchronous operations

A **write** operation takes data from a buffer and writes it to a channel

A **read** reads data from a channel and writes it to a buffer

* Channel interfaces
1. FileChannel
    - has a cursor
    - multiple reads and writes
    - thread safe
    
1. DatagramChannel:
    - access to a socket
    - supports multicast
    - multiple concurrent reads and writes
    
1. SocketChannel and ServerSockerChannel:
    - supports asynchronous operations
    - supports multiple non-concurrent reads and writes
    
- READ
- READ_WRITE
- PRIVATE
    
create using factories

* Buffer interfaces (in memory)
1. ByteBuffer
1. CharBuffer
1. IntBuffer

create using factories

* properties
    1. capacity = size of backing array
    1. current position
    1. limit
    
create views on buffers to create sub buffers

a buffer can be marked

* basic operations:
    1. rewind: clears the mark and sets current pos to zero
    1. reset: sets teh current position to the prev set mark
    1. flip: sets the limit to the curr pos and rewinds the buffer
    1. clear: clears the buffer
    
  