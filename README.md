# KBRelay

## Requirements

- [KBRelay App](https://github.com/azawat7/kbrelay-app)
- [Fabric Language Kotlin](https://modrinth.com/mod/fabric-language-kotlin)

## Commands

| Command                   | Description                              |
| ------------------------- | ---------------------------------------- |
| `/kbrelay info`           | Show the current listening port          |
| `/kbrelay port <1-65535>` | Change the port and restart the listener |
| `/kbrelay reset`          | Reset port to default (25560)            |

## Building from source

Requires Java 21+.

```bash
./gradlew build
```

Output: `build/libs/kbrelay-<version>.jar`
