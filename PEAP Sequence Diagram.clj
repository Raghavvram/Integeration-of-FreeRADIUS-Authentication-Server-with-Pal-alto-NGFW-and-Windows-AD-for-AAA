   +--------------+        +----------------+        +-----------------------+
   |    Client    |        |  Authenticator |        | Authentication Server |
   | (Supplicant) |        |  (Switch /     |        | (RADIUS / FreeRADIUS) |
   |              |        |  Access Point) |        |                       |
   +--------------+        +----------------+        +-----------------------+
          |                        |                           |
          |Phase 1: Server Authentication & TLS Tunnel Creation|
          |--------------------------------------------------->|
          |        Server sends public key certificate         |
          |<---------------------------------------------------|
          |         Client verifies the certificate            |
          |       and establishes encrypted TLS tunnel         |
          |<==================================================>|
          |           Secure TLS Tunnel Established            |
          |                        |                           |
          |    Phase 2: Client Authentication over TLS Tunnel  |
          |                        |                           |
          |       Client sends credentials over TLS tunnel     |
          |                        |                           |
          |             Server validates credentials           |
          |                        |                           |
          |<-------------- Success / Failure ----------------->|
          |                        |                           |
          |         If Success: Network Access Granted         |
          |<-------------------------------------------------->|
          |                        |                           |
          |                        |                           |
