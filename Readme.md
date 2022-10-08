![SimpleLobby](https://github.com/JavaDevMC/images/blob/main/SimpleLobby.png?raw=true)

SimpleLobby is a easy to setup lobby plugin for the minecraft version 1.8 - 1.19


## Commands

```xml
/sl setspawn
/sl reload
/sl spawn
/spawn
/hub
/lobby
/stuck
/l
```

## Permissions

```xml
simplelobby.admin
simplelobby.cmd
```

## Config

```java
Config:
  Config:
  TeleportOnJoin: true
  DisableBlockBreak: true
  DisableBlockPlace: true
  DisablePVP: true
  DisableDamage: true
  WelcomeMessageB: false
  JoinMessageB: true
  LeaveMessageB: true
  FireworkOnJoin: true
  TeleportOnRespawn: true
  DisableHunger: true
  DisableWeatherChange: true
Messages:
  WelcomeMessage: '&aWelcome %player%'
  JoinMessage: '&a[+] &6%player% joined the server'
  LeaveMessage: '&c[-] &6%player% left the server'
  PlaceBlocksMessage: '&cYou cant place blocks here!'
  BreakBlocksMessage: '&cYou cant break blocks here!'
  PlayerHitMessage: '&cPVP is here disabled!'
  Prefix: '&bSimpleLobby '
  SpawnTeleportMessage: '&aTeleported to spawn!'
Scoreboard:
  isEnabled: true
  onlyInLobbyWorld: true
  Title: '&b&lSimpleLobby'
  line0: ' '
  line1: '&aWelcome %player%'
  line2: ' '
  line3: ''
  line4: 'Change the text in:'
  line5: '&nSimpleLobby/plugins/config.yml'
  line6: ''
  line7: ''
  line8: ''
  line9: ''
  line10: '&7yourserver.net'
Commands:
  SpawnTeleport: true

```
 

- [SpigotMC](https://www.spigotmc.org/resources/simplelobby-1-8-x.105614/)
- [Java Doc](https://cozy-faun-fb7369.netlify.app)
- [MaximClient Discord](https://discord.gg/gbqF32Qsv2)
- [Donate](https://www.paypal.com/donate/?hosted_button_id=9WKETML4G9JHE)

You can use my code, but please give credits!
