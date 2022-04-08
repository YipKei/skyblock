# SkyBlock

**English**|[中文](README_cn.md)

SkyBlock is a module for [fabric-carpet](https://github.com/gnembon/fabric-carpet)
originally based on [skyrising/skyblock](https://github.com/skyrising/skyblock).

This mod aims to provide an expert level SkyBlock gameplay that depends on players' knowledge
of Minecraft mechanics. In some cases, outside tools such as [Chunkbase](https://www.chunkbase.com/)
or [MiniHUD](https://www.curseforge.com/minecraft/mc-mods/minihud) will be helpful.
Usage of these is encouraged. Sometimes extended grinding or AFK sessions will be
required for progression, although I've tried to minimize this in some cases.
Unless a command is run to enable features or SkyBlock world generation is chosen,
the mod will not affect other saves on the client it is installed on.

## Installation
- Install [Fabric](https://fabricmc.net/use)
- Download [fabric-carpet](https://www.curseforge.com/minecraft/mc-mods/carpet/files/)
- Download [fabric-api](https://www.curseforge.com/minecraft/mc-mods/fabric-api/files)
- Download [SkyBlock and the Datapack](https://github.com/jsorrell/skyblock/releases)
- Place fabric-carpet, fabric-api, and SkyBlock into `<minecraft-directory>/mods/`

## Usage

### Singleplayer
- `Create New World`
- Set the Difficulty to Hard (for more armor/weapon drops)
- Select the downloaded Datapack
- Set Allow Cheats to `ON` so you will be able to enable mod features
- Click on `More World Options...`
- Choose `World Type: SkyBlock`
- Create the world
- Run `/function skyblock:enable_features` to enable SkyBlock features

### Multiplayer
The mod and datapack are only required on the server.

- Open `server.properties`
- Change `level-type=default` to `level-type=skyblock`
- Make sure to delete or move the world folder in order to create a new world
- Move the downloaded datapack to the `datapack` directory
- Run `function skyblock:enable_features` to enable SkyBlock features

## Features

### SkyBlock Generation
A SkyBlock world generates exactly like a Default generation world, but with every block removed.
Biomes and Structure Bounding Boxes are kept in place.
This means Husks will still spawn in Deserts and Blazes will spawn in Nether Fortresses, for example.

Only two things are generated:
- A small starting island where you spawn:
![small spawn platform with grass, mycelium, nylium, and a tree](screenshots/spawn_platform.png?raw=true "Spawn Platform")

- All end portal frames and silverfish spawners:
![end portal frame remains](screenshots/end_portal.png?raw=true "End Portal Frame")
  
Even with every block removed, almost every block is obtainable and almost every mob is spawnable,
using only *Vanilla* features.

### Additional Mod Features ###
SkyBlock generation does, however, leave a few unobtainable resources.
In addition to generation, this mod also fills in the gaps,
making as minimal and Minecrafty changes as possible.

---

#### Additional Wandering Trader Trades ####
Provides *tall flowers* and *Lava Buckets*

Disable with ```/skyblock setDefault wanderingTraderSkyBlockTrades false```

Tall Flowers trades mimic Bedrock.

##### Additional Trades: #####

###### Tier 1
| Item      | Price | Trades until disabled |
|-----------|-------|-----------------------|
| Lilac     | 1     | 12                    |
| Rose Bush | 1     | 12                    |
| Peony     | 1     | 12                    |
| Sunflower | 1     | 12                    |

###### Tier 2
| Output Item | Input Item | Price | Trades until disabled |
|-------------|------------|-------|-----------------------|
| Lava Bucket | Bucket     | 16    | 1                     |

---

#### Lightning Electrifies Vines ####
Provides *Glow Lichen*

Disable with ```/skyblock setDefault lightningElectrifiesVines false```

If lightning strikes Glowstone with vines attached,
the vines will turn into Glow Lichen.
It can also strike a Lightning Rod on the Glowstone.

---

#### Renewable Budding Amethysts ####
Provides *Budding Amethysts*

Disable with ```/skyblock setDefault renewableBuddingAmethysts false```

A lava block surrounded by Calcite which is then surrounded by Smooth Basalt
will eventually turn into a Budding Amethyst.

##### How to build structure: #####

![lava source](screenshots/amethyst_step_1_240.png?raw=true "Budding Amethyst Generation Step 1")
---->
![Lava surrounded by calcite](screenshots/amethyst_step_2_240.png?raw=true "Budding Amethyst Generation Step 2")
---->
![Calcite surrounded by smooth basalt](screenshots/amethyst_step_3_240.png?raw=true "Budding Amethyst Generation Step 3")

After some time (2 hours on average), the Lava in the center will turn into a Budding Amethyst.

![Lava has become budding amethyst](screenshots/amethyst_result_240.png?raw=true "Budding Amethyst Generation Result")


---

#### End Gateways Spawn Chorus ####
Provides *Chorus Fruit* and *Chorus Flowers*

Disable with ```/skyblock setDefault gatewaysSpawnChorus false```

When an End Gateway is taken to a position over the void, the Endstone island
generated spawns with a Chorus Tree on it.

---

#### Dolphins Find Hearts of the Sea ####
Provides *Hearts of the Sea*

Disable with ```/skyblock setDefault renewableHeartsOfTheSea false```

When a dolphin gives up finding a treasure chest after being given a fish,
they will find a Heart of the Sea.

---

#### Ender Dragons Can Drop Heads ####
Provides *Dragon Heads*

Disable with ```/skyblock setDefault renewableDragonHeads false```

When an Ender Dragon is killed by a Charged Creeper, she will drop her head.

---

#### Shulkers Spawn On Dragon Kill ####
Provides *Shulkers*

Disable with ```/skyblock setDefault shulkerSpawning false```

When an Ender Dragon is re-killed, a Shulker spawns on top of the Bedrock pillar.

---

#### Anvils Compact Coal into Diamonds ####
Provides *Diamonds*

Disable with ```/skyblock setDefault renewableDiamonds false```

A Falling Anvil crushes a stack of Coal Blocks into a Diamond.

---

#### Goats Ram Open Nether Wart Blocks ####
Provides *Nether Wart*

Disable with ```/skyblock setDefault rammingWart false```

When a Goat rams a Nether Wart Block, it will break into Nether Wart.

---

#### Foxes Spawn With Berries ####
Provides *Glow Berries* and *Sweet Berries*

Disable with ```/skyblock setDefault foxesSpawnWithBerries false```

When a fox spawns with an item, there is a 15% chance the item is Glow Berries
and another 15% chance it is Sweet Berries.
The fox will eat them soon after spawning, so be quick.

---

### Additional Datapack Features ###
The included datapack provides additional recipes, and advancements.

When possible, changes were added to the datapack over the mod for ease of user customization.

---

#### Netherrack from Rotten Flesh ####
Provides *Netherrack*

Netherrack is craftable from 9 Rotten Flesh

---

#### Calcite and Tuff Obtainable ####
Provides *Calcite* and *Tuff*

Put Diorite in a Blast Furnace for Calcite.

Put Andesite in a Blast Furnace for Tuff.

---

#### Husks Drop Sand ####
Provides additional *Sand*

Husks drop Sand because obtaining large amounts from a Wandering Trader is tedious.

---

#### Piglin Brutes Drop Ancient Debris ####
Provides *Ancient Debris*

A Carpet setting enables Piglin Brutes to spawn in bastions.
These Brutes have a chance to drop Ancient Debris.

---

#### Cobbled Deepslate is Craftable ####
Provides *Cobbled Deepslate*

Craft Cobbled Deepslate with 9 Cobblestone in a crafting grid.

---

#### Elytra Obtainable by Fishing in the End ####
Provides *Elytra*

Elytra can be caught rarely as treasure items when fishing in the End.

---

#### Red Sand Recipe ####
Provides additional *Red Sand*

Sand combined 1-1 with Red Dye makes Red Sand.

---

#### Spider Jockeys Drop Cobwebs ####
Provides *Cobwebs*

When a player kills a Spider Jockey,
the first half killed drops a cobweb.

---

#### Cocoa Beans Obtainable by Fishing in Jungles ####
Provides *Cocoa Beans*

Matching Bedrock, Cocoa Beans can be obtained as a junk item when fishing in a Jungle.

---

#### Ores Obtainable in Smithing Table ####
Provides *ores*

All ores can be crafted in a smithing table using a block of the base stone material and
a block of the ore's material.

For example, Nether Gold Ore can be crafted with Netherrack and a Block of Gold.

---

#### Horse Armors are Craftable ####
Provides *Iron Horse Armor*, *Golden Horse Armor*, and *Diamond Horse Armor*

Craft Horse Armors with their respective materials in a **H** shape.

---

#### Cats Gift Enchanted Golden Apples ####
Provides *Enchanted Golden Apples*

Cats will rarely bring the player an Enchanted Golden Apple as a morning gift.

---

#### Piglins Give Gilded Blackstone ####

Provides *Gilded Blackstone*

Piglins will rarely give Gilded Blackstone when bartering.

---

#### Creepers Drop All Music Disks in the Nether ####

Provides the music discs *Pigstep* and *otherside*

When Creepers are killed by Skeletons in the Nether, they can drop any music disc, including Pigstep and otherside.

---

#### Zoglins Drop Snout Banner Patterns ####

Provides *Snout Banner Pattern*

Title says it all.

---

#### Magma Cream Recipe Disabled ####

The vanilla Magma Cream recipe is too easy. Make a Magma Cube farm instead.

---

#### War Pigs Advancement Changed ####

In a SkyBlock world, the War Pigs advancement is unobtainable because it requires generated chests.

The advancement is now obtainable by killing a Piglin Brute.

----

### Numerous Added Advancements ###
SkyBlock advancements help guide progression, as well as serve to document the mod's changes to vanilla.

With all features enabled, all vanilla advancements can be completed (although War Pigs is changed).


## Carpet Features
Installation will also enable these `fabric-carpet` features.

With the `fabric-carpet` options below enabled, all blocks, items, and mobs obtainable in vanilla survival are obtainable in SkyBlock.
- [desertShrubs](https://github.com/gnembon/fabric-carpet/wiki/Current-Available-Settings#desertshrubs) for Dead Bushes
  - run `/carpet setDefault desertShrubs false` to disable
- [renewableSponges](https://github.com/gnembon/fabric-carpet/wiki/Current-Available-Settings#renewablesponges) for Sponges
  - run `/carpet setDefault renewableSponges false` to disable
- [piglinsSpawningInBastions](https://github.com/gnembon/fabric-carpet/wiki/Current-Available-Settings#piglinsSpawningInBastions) for Ancient Debris
  - run `/carpet setDefault piglinsSpawningInBastions false` to disable
  
## Acknowledgements
- [@skyrising](https://github.com/skyrising/skyblock) for the initial mod idea and some source code

- [@DeadlyMC](https://github.com/DeadlyMC/Skyblock-datapack) for the initial ideas for the datapack

- [@gnembon](https://github.com/gnembon/fabric-carpet) for `fabric-carpet`

## License
This project is licensed under the terms of the MIT license.
