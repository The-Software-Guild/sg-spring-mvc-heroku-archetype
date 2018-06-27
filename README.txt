SWC Guild Spring MVC Maven Archetype Installation Instructions
==============================================================
    1. Copy archetype-catalog.xml to .m2 directory (combine w/ existing if there)
    2. Open terminal window in the archetype-heroku-spring-mvc directory
       and type 'mvn clean install'
    3. Configure NetBeans:
        a. Go to Tools-->Options
        b. Select 'Java' and then the 'Maven' tab
        c. Click 'Index Now'
    4. Test Setup:
        a. Click File-->New Project
        b. Select Maven-->Project from Archetype
        c. Type 'sg-' in the Search bar - if sg-heroku-archetype
           appears as an option, your configuration is complete.
