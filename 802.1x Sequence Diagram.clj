   +--------------+        +-----------------+        +-----------------------+
   |    Client    |        |  Authenticator  |        | Authentication Server |
   | (Supplicant) |        |   (Switch /     |        | (RADIUS / FreeRADIUS) |
   |              |        |  Access Point)  |        |                       |
   +--------------+        +-----------------+        +-----------------------+
          |                       |                          |
          |       Initialization: Port unauthorized          |
          |<----------------------|                          |
          |                       |                          |
          | 1. EAP-Request Identity (Who are you?)           |
          |<----------------------|                          |
          |                       |                          |
          | 2. EAP-Response Identity (Here is my identity)   |
          |---------------------->|                          |
          |                       |                          |
          |         Forward EAP-Response                     |
          |                       |------------------------->|
          |                       |                          |
          |              3. Verify Credentials               |
          |                       |                          |
          |   4. EAP-Success (Authorize)  or                 |
          |      EAP-Failure (Deny)                          |
          |                       |<-------------------------|
          |          Forward Result (Accept or Reject)       |
          |<----------------------|                          |
          |                       |                          |
          |      If success: Port authorized, allow network  |
          |------------------------------------------------->|
          |                       |                          |

