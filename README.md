# Synchronization-Router
simulate a limited number of devices connected to a router’s Wi-Fi using Java threading and semaphore. Routers can be designed to limit the number of open connections For example, a Router may wish to have only N connections at any point in time. As soon as N connections are made, the Router will not accept other incoming connections until an existing connection is released.

rules were applied:
• The Wi-Fi number of connected devices is initially empty.
• If a client is logged in (print a message that a client has logged in) and if it can be served (means that it can reach the internet), then the client should
perform the following activities:
◆ Connect
◆ Perform online activity
◆ Log out
