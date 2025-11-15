   +--------------+        +----------------+        +-----------------------+
   |    Client    |        |  Authenticator |        | Authentication Server |
   | (Supplicant) |        |   (Switch /    |        |   (FreeRADIUS / AD)   |
   |              |        |  Access Point) |        |                       |
   +--------------+        +----------------+        +-----------------------+
          |                        |                         |
          |           Tunnel Establishment (PEAP)            |
          |<================================================>|
          |          Secure TLS Tunnel Established           |
          |                        |                         |
          |         Server sends Challenge to Client         |
          |                        |<------------------------|
          |             Client hashes response               |
          |       (Challenge + Password) & sends back        |
          |----------------------->|                         |
          |            Server performs same hash             |
          |            and compares responses                |
          |                        |------------------------>|
          |       If match, server authenticates user        |
          |                        |                         |
          |          Mutual Authentication Successful        |
          |<================================================>|
          |               Access Granted Message             |
          |                        |------------------------>|
          |         Client Granted Network Access            |
          |                        |                         |

