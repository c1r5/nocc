# NOCC

NOCC is a Fabric mod that helps convert coordinates between the Overworld and the Nether.

## Version

- Mod version: `1.0.0`
- Minecraft version: `26.1.2`
- Fabric Loader: `0.19.3`
- Fabric API: `0.152.1+26.1.2`

The mod name shown in metadata includes the mod version and Fabric API version.

## Features

- Shows current coordinates in the HUD.
- Shows the converted coordinates for the opposite dimension.
- In the Overworld, the HUD shows the current Overworld coordinates and the Nether conversion.
- In the Nether, the HUD shows the current Nether coordinates and the Overworld conversion.
- Provides `/nocc` commands for explicit coordinate conversion.

## Commands

Convert Overworld coordinates to Nether coordinates:

```text
/nocc nether x y z
```

Convert Nether coordinates to Overworld coordinates:

```text
/nocc overworld x y z
```

The `y` value is preserved. The command uses Minecraft's native coordinate parser, so relative coordinates such as `~ ~ ~` are supported.

## Development

Run tests:

```sh
./gradlew test
```

Build the mod:

```sh
./gradlew build
```

## Releases

GitHub Actions builds the project for every push and pull request.

To create a GitHub release and upload the generated `.jar` files from `build/libs`, push a tag:

```sh
git tag v1.0.0
git push origin v1.0.0
```

## License

This project is licensed under CC0-1.0.
