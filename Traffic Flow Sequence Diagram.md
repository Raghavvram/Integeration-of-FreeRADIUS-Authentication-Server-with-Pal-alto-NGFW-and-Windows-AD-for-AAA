+--------------------+      +--------------------+        +------------------------+      +------------------------+         +-------------------+
|      Client        |      |    Access Point    |        |    FreeRADIUS Server   |      |   Windows Server (AD)  |         |     OPNsense      |
| (802.1X Supplicant)|      | (Authenticator &   |        |  (802.1X & RADIUS)     |      |   Domain Controller    |         |     Firewall      |
|                    |      |   RADIUS Client)   |        |                        |      |                        |         |  (RADIUS Client)  |
+---------+----------+      +---------+----------+        +-----------+------------+      +-----------+------------+         +---------+---------+
          |                           |                               |                               |                                |
          | DHCP Request/Reply via dnsmasq                            |                               |                                |
          |-------------------------->|                               |                               |                                |
          |                           |                               |                               |                                |
          | 1. 802.1X/EAP Start: Initialization                       |                               |                                |
          |---------------------------------------------------------->|                               |                                |
          |                           |                               |                               |                                |
          | 2. Server Authentication & TLS Tunnel Creation            |                               |                                |
          |                           |------------------------------>|                               |                                |
          |                           |     Server Certificate        |                               |                                |
          |                           |<------------------------------|                               |                                |
          |                           |     TLS Tunnel Established    |                               |                                |
          |                           |<=============================>|                               |                                |
          |                           |                               |                               |                                |
          | 3. Client sends EAP-MSCHAPv2 Credentials over TLS Tunnel  |                               |                                |
          |---------------------------------------------------------->|                               |                                |
          |                           |                               |                               |                                |
          | 4. FreeRADIUS verifies Credentials with Samba ntlm_auth   |                               |                                |
          |                           |-------------------------------------------------------------->|                                |
          |                           |                               |        Validates User         |                                |
          |                           |                               |<---------------------------------------------------------------|
          |                           |                               |                               |                                |
          | 5. FreeRADIUS sends Access-Accept/Reject to AP            |                               |                                |
          |                           |<--------------------------------------------------------------|                                |
          |                           |                               |                               |                                |
          | 6. AP authorizes port (if success), allows network access |                               |                                |
          |<----------------------------------------------------------|                               |                                |
          |                           |                               |                               |                                |
          | 7. User traffic routed through OPNsense Firewall          |                               |                                |
          |                           |                               |                               |<------------------------------>|
          |                           |                               |                               |        Applies Policies        |
          |                           |                               |                               |                                |
