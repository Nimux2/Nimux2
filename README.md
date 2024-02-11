# Back to Au Brasseur Part 1

## Sujet 

Souvenez-vous, "Au Brasseur" est un restaurant Strasbourgeois qui propose essentiellement des tartes flambées et des bières. Le propriétaire vous avait contacté pour informatiser sa caisse. Il vous avait demandé de réaliser une application qui permet de gérer l'encaissement des tables à la fin des repas.

L'application permet à ce stade :
- de gérer une seule table active à la fois ;
- de (ré)initialiser la caisse ;
- de marquer la table active comme encaissée ;
- de créer une nouvelle table dès que la table active est marquée comme encaissée ;
- d'ajouter/supprimer des plats et boissons à la table active ;
- d'afficher à tout instant et séparément la somme totale des boissons et celle des tartes flambées, accumulée depuis l'ouverture de la caisse pour toutes les tables déjà encaissées.

A noter, une table encaissée ne peut pas redevenir active.

Il est de votre ressort, à l'échelle de votre groupe de TP, de :
- **garantir le bon fonctionnement de l'ensemble de l'application** ;
- développer les fonctionnalités ci-dessous dans le temps imparti ;
- travailler tous ensemble sur la même application par le biais d'un unique dépôt *git* (**have fun :)**).

Les fonctionnalités attendues sont :
- la gestion de plusieurs tables actives en parallèle. Il doit être possible de créer ou supprimer de nouvelles tables sur lesquelles il sera possible d'ajouter des produits ou de tous les retirer ;
- la possibilité de trier les produits d'une table active selon leur nom ou leur prix de vente.

Si vous deviez vous mettre en situation, vous pouvez vous imaginer en entreprise et que vous avez une démonstration de votre application à réaliser à la fin de la séance dont le but est de **démontrer que celle-ci fonctionne complètement et que rien n'a été laissé au hasard**.

## Consignes générales et rendu

- Tous les supports sont autorisés.
- Il vous est fortement conseillé de communiquer de quelque façon que ce soit avec **tous les membres de votre groupe de TP** pour vous répartir les tâches.
- Le rendu est à faire sur un unique dépôt de groupe, **dans une branche git nommé "rendu"** : pensez à prendre le temps nécessaire pour réaliser le rendu final sur votre branche avant la fin du tp.
- N'oubliez pas de "pusher" à la fin du TP.
- Attention, **les commits effectués APRÈS l'horaire de fin du TP ne seront pas pris en compte** : pensez à prendre le temps nécessaire à ces opérations avant l'heure fatidique.

Vous devrez fournir : 
- **le code source** ;
- tout autre élément qui vous semble pertinent dans un éventuel document markdown **complement.md**.

## Préparation du dépôt Git

- Un dépôt unique pour tous vous gouverner : l'URL de votre dépôt Git doit être de la forme https://git.unistra.fr/[votre_groupe_de_tp]/a41, renommez-le si ce n'est pas le cas via le menu "Settings -> General -> Advanced -> Change Path" sur Gitlab. (ex: TP1)
- Forkez ce dépôt dans le groupe créé ci-dessus.
- Votre dépôt doit être privé et vous devez ajouter votre enseignant de TD et votre responsable de module comme Reporter.