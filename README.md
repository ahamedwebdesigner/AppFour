"# AppFour - servlet project" 
Creating servlet project using maven
------------------------------------------------------------------------
- create maven project without template
- convert created project to project facet
	- dynamic module to 3.1
	- add service runtime and increase java version
		- java build path -> libraries - remove existing java version
		- add workspace JRE ie 1.8
		- add server runtime 
	- delete web content directory
	- src -> add webapp  for maven standard
- add webapp for deployment assembly