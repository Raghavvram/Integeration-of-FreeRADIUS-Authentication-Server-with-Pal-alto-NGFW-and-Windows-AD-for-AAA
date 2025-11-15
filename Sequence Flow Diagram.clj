Client               Access Point           FreeRADIUS           Windows AD           OPNsense Firewall
  |                        |                     |                   |                        |
  |------DHCP Request----->|                     |                   |                        |
  |<-----DHCP Reply--------|                     |                   |                        |
  |                        |                     |                   |                        |
  |---EAP Start (802.1X)-->|                     |                   |                        |
  |                        |---RADIUS Access-Request (EAP-Start)---->|                        |
  |                        |                     |                   |                        |
  |<---RADIUS Access-Challenge (Server Cert)-----|                   |                        |
  |<-----------------------------------------------------------------TLS Tunnel Established-->|
  |                        |                     |                   |                        |
  |----EAP Response (MS-CHAPv2 Credentials)----->|                   |                        |
  |                        |---RADIUS Access-Request (MS-CHAPv2)---->|                        |
  |                        |                     |                   |----Samba ntlm_auth---->|
  |                        |                     |                   |<---Credential Check----|
  |                        |<-----RADIUS Access-Accept/Reject--------|                        |
  |<--EAP Success/Failure--|                     |                   |                        |
  |                        |                     |                   |                        |
  |<-----Port Authorized---|                     |                   |                        |
  |                        |                     |                   |                        |
  |----------User Traffic Routed through Firewall------------------->|                        |
  |                        |                     |                   |                        |
