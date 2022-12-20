# MTR Addon Template

An template for compiling addons for [Minecraft Transit Railway](https://github.com/jonafanho/Minecraft-Transit-Railway).

Also can be used for general cross-loader and cross-version setups, just delete the MTR dependencies.



## Note

Make sure you search and replace all package names and references of "MtrAddonTemplate" in all files! Otherwise, your mod might conflict with others.

Look for `mtraddontemplate`, `mtr-addon-template` and `MtrAddonTemplate`.



## Setup

1. Clone this repository
2. Sync the Gradle project
3. To switch Minecraft versions or on first run:
   1. Sync the Gradle Project
   2. In the root project, run the Gradle `setupLibrary` task
   3. Sync the Gradle Project again

