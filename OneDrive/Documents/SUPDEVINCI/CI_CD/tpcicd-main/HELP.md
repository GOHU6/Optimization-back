[TOC]

# TP (10pts)

L'objectif de ce TP est d'industrialiser la gestion d'un projet avec :
 - l'utilisation d'un gestionnaire de configuration,
 - la mise en place d'une chaîne d'intégration continue.

Les bonnes pratiques ne sont pas à négliger :
 - respect des branches,
 - justesse des messages.

/!\ Le projet ne sera pas public.

Le travail en groupe est autorisé jusqu'à 3 personnes.
Le fichier **credits.md** est indispensable et permettra de vous identifier.

Les captures d'écran seront stockées dans le répertoire **captures** du projet.

Le rendu sera à effectuer sur **Pepal** ou par mail *nicolas.sanou@wijin.tech* .


## Passer sous Gitlab (1pt)

Créer un nouveau projet tpcicd sur votre compte Gitlab.
Le projet doit être **privé**.

Faire en sorte d'ignorer le répertoire **target** et son contenu.

Le fichier **credits.md** doit être renseigné et disponible sur votre unique branche.

Effectuez une capture d'écran **captures/01.png** avec en visibilité  :
 - l'URL du projet
 - le graphe des branches

## Plannification (1pt)

Générer un board de type KANBAN qui permet de 
 - gérer 2 sprints :
    - Sprint_v1
    - Sprint_v2
 - gérer les états de tickets :
    - BACKLOG
	- TODO
	- IN_PROGRESS
	- TEST
	- DONE
 - gérer la nature :
    - BUG
	- USER_STORY
Créer un tickets de chaque nature, les associer à l'un des sprints 
et dans des états différents.

Effectuez une capture d'écran **captures/02.png** avec en visibilité  :
 - l'URL du projet
 - le tableau créé (sans filtrage).

Effectuez une capture d'écran **captures/03.png** avec en visibilité  :
 - l'URL du projet
 - le tableau créé avec un filtrage sur les tickets liés au Sprint_v1.

Effectuez une capture d'écran **captures/04.png** avec en visibilité  :
 - l'URL du projet
 - le tableau créé avec un filtrage sur les tickets liés au Sprint_v2.


## Gitflow (1pt)

Créer les branches indispensables à la gestion du projet avec Gitflow.

Protéger ces branches pour empêcher le push sur ces branches principales.

Effectuez une capture d'écran **captures/05.png** avec en visibilité  :
 - l'URL du projet
 - la liste des branches protégées.


## Enregistrer un Runner pour votre projet (1pt)

Depuis votre répertoire c:\gitlabrunner (ou équivalent), 
procédez à l'enregistrement du runner (console DOS admin sous Windows).

Le service runner doit être redémarré (lecture de la configuration).

Effectuez une capture d'écran **captures/06.png** avec en visibilité  :
 - l'URL du projet
 - la liste des runners disponibles pour ce projet.

## Initialisation CI/CD (1pt)

Créer un branche de travail pour la mise en place de l'intégration continue (expérimentation).

Enrichissez votre projet avec une chaine d'intégration continue gérée par Gitlab.
Cette chaîne peut ne contenir qu'une étape pour commencer : la compilation.

Vérifier le déroulement de cette première automatisation.

Ajouter le cache ci-dessous à votre configuration de la chaine d'intégration continue :
```yaml
cache:
  paths:
    - .m2/repository/
    - target/
```


Effectuez une capture d'écran **captures/07.png** avec en visibilité  :
 - l'URL du projet
 - les runners disponibles pour ce projet.

Effectuez une capture d'écran **captures/08.png** avec en visibilité  :
 - l'URL du projet
 - le pipeline exécuté sans erreur.

## Tests unitaires (1pt)

Ajouter l'étape des tests.

Effectuez une capture d'écran **captures/09.png** avec en visibilité  :
 - l'URL du projet
 - le pipeline exécuté avec l'étape des tests.

## Correction (1pt)

Identifier la correction à apporter pour que les tests réussissent.
Stocker le résultat de votre analyse de manière à aider le correcteur (création d'un ticket à partir d'un échec de job).

Corriger en respectant les règles de Gitflow.

Effectuez une capture d'écran **captures/10.png** avec en visibilité  :
 - l'URL du projet
 - le pipeline exécuté avec l'étape des tests.

Effectuez une capture d'écran **captures/11.png** avec en visibilité  :
 - l'URL du projet
 - le graphe des branches du projet.

## Mesure de la qualite (1pt)

Ajouter l'étape de la mesure de qualité avec CodeClimate.
Ne pas oublier de conserver le résultat de l'audit de qualité.

Effectuez une capture d'écran **captures/12.png** avec en visibilité  :
 - l'URL du projet
 - le pipeline exécuté avec l'étape de la mesure de qualité.

Effectuez une capture d'écran **captures/13.png** avec en visibilité  :
 - l'URL du projet
 - le stockage de cet audit.


## Packaging (1pt)

Ajouter l'étape du packaging.


Vous pouvez vous inspirer du script ci-dessous :
```yaml
    script:
      - echo $CI_REGISTRY_PASSWORD | docker login -u $CI_REGISTRY_USER $CI_REGISTRY --password-stdin
      - docker build -t $CI_REGISTRY_IMAGE .
      - docker push $CI_REGISTRY_IMAGE
```
Il nécessitera de configurer les variables :
 - CI_REGISTRY_USER avec votre login Gitlab
 - CI_REGISTRY_PASSWORD avec votre mot de passe Gitlab


Effectuez une capture d'écran **captures/14.png** avec en visibilité  :
 - l'URL du projet
 - le pipeline exécuté avec l'étape de packaging.

Effectuez une capture d'écran **captures/15.png** avec en visibilité  :
 - l'URL du projet
 - le stockage du produit de cette étape.


## Finalisation (1pt)

Tout semble OK pour la mise en production 

Reporter tous vos changements en respectant Gitflow vers la branche principale.

Effectuez une capture d'écran **captures/16.png** avec en visibilité  :
	- l'URL du projet
	- les branches du projet.

Effectuez une capture d'écran **captures/17.png** avec en visibilité  :
	- l'URL du projet
	- la liste des commits.

Effectuez une capture d'écran **captures/18.png** avec en visibilité  :
	- l'URL du projet
	- la liste des pipelines.

## Rendu

Exporter votre projet sous la forme d'une archive.

Ajouter les dernières captures à l'archive :
 - captures/16.png
 - captures/17.png
 - captures/18.png

Déposez votre travail dans **Pepal** !



# Getting Started

## Register a gitlab runner

Les informations :
 - Executor : docker
 - Gitlab url : https://gitlab.com/
 - Tags : 
 - Image : alpine


## Maven commands

**Compilation**
```bash
chmod +x ./mvnw
./mvnw compile -Dmaven.test.skip=true
```


**Tests** (target/surefire-reports/)
```bash
chmod +x ./mvnw
./mvnw test
```


Generate a jar (target/tpcicd-0.0.1-SNAPSHOT.jar)
```bash
chmod +x ./mvnw
./mvnw package -Dmaven.test.skip=true
```


Generate Docker image :
```bash
docker build --tag tpcicd:latest .
```


Execute your app from your local Docker repository :
```bash
docker run --rm tpcicd:latest
```
