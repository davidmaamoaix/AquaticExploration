# AquaticExploration
A temporary repo for one of my previous mod (that was in the process of updating to 1.14).

## Repository Guide
The structure of this project is... a bit convoluted (at least to a sleepy person like me). Just in case you as the viewer get lost or I forget what I was doing due to my terrible memory, this section provides an illustration more convoluted than the project structure itself of the project structure.
Normally, the following sections should be distributed as Javadocs (or alternatively comments) in their according class; however, that sounds like a lot of work to the viewer, so here it is.

### Naming Convention
- Registry Name (without prefix): ```daniel_the_bad_person```
- Unlocalized Tooltip: ```tooltip.<Mod ID>.<Registry Name>```
- Unlocalized Chat Message: ```chat.<Mod IDD>.<Chat Name>```

### Organization
Basically package names.
- \<Name of a Registry Type but in Plural and Lower Cases\>: Contains registry entries and setup of the said registry. There will be a class named ```Aquatic<Registry Type Name>```, which contains the registering of the registry entries of the registry. The rest are just base classes and implementations.

Other stuff are probably self-explanatory. Oh and, I overrided the rendering of ```ItenEntity``` because yay.