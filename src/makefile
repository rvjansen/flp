PACKAGE_DIR=build/com/rvjansen

NRX_COMPILE_COMMAND = java -Dnrx.compiler=ecj org.netrexx.process.NetRexxC
NRX_COMPILE_FLAGS = -comments -time -keepasjava -replace -warnexit0 -compact -nocrossref -utf8

#JAVA_COMPILE_COMMAND = java org.eclipse.jdt.internal.compiler.batch.Main
JAVA_COMPILE_COMMAND = javac
#JAVA_COMPILE_FLAGS = -warn:-unusedPrivate -warn:-unusedLocal -Xemacs -source 1.5
JAVA_COMPILE_FLAGS = -d build

.java.class:
	$(JAVA_COMPILE_COMMAND) $(JAVA_COMPILE_FLAGS) $*.java

.nrx.class:
	$(NRX_COMPILE_COMMAND) $*.nrx $(NRX_COMPILE_FLAGS)
#	$(JAVA_COMPILE_COMMAND) $(JAVA_COMPILE_FLAGS) $*.java

NRX_SRC		:= $(wildcard *.nrx)
NRX_OBJS	:= $(NRX_SRC:.nrx=.class)
JAVA_SRC	:= $(wildcard *.java)
JAVA_OBJS	:= $(JAVA_SRC:.java=.class)
TARGET		:= thebook
PDFTARGET	:= $(TARGET).pdf
TEX_SRC		:= $(wildcard *.tex)
LATEX_EXE	:= pdflatex -file-line-error


.SUFFIXES: .nrx .nry .njp .class .skel .xsl .java .pdf

#
# target all compiles the netrexx and java code
#
# all::	$(PACKAGE_DIR)/KBRequest.class $(PACKAGE_DIR)/KBResponse.class $(PACKAGE_DIR)/KBServerInterface.class $(PACKAGE_DIR)/KBClient.class $(PACKAGE_DIR)/Fact.class $(PACKAGE_DIR)/Datum.class $(PACKAGE_DIR)/TimeIt.class $(PACKAGE_DIR)/$(NRX_OBJS) $(PACKAGE_DIR)/$(JAVA_OBJS)
# 	mkdir -p $(PACKAGE_DIR)
# 	cp $*.nrx $(PACKAGE_DIR)
# 	cd $(PACKAGE_DIR);$(NRX_COMPILE_COMMAND) $*.nrx $(NRX_COMPILE_FLAGS)
# 	$(JAVA_COMPILE_COMMAND) $(JAVA_COMPILE_FLAGS) $*.java

all::
	mkdir -p $(PACKAGE_DIR)
	cp *.nrx $(PACKAGE_DIR)
	cd $(PACKAGE_DIR);$(NRX_COMPILE_COMMAND) *.nrx $(NRX_COMPILE_FLAGS)
	$(JAVA_COMPILE_COMMAND) $(JAVA_COMPILE_FLAGS) *.java

#
# target clean removes compiled products
#
.PHONY: clean
clean: 
	rm -f *.class
	rm -f *.crossref
	rm -f *.bak
	rm -f *~
	rm -f input/*~
	rm -f *.java.keep
	find . -name "*.nrx" | awk '{$$2 = $$1 ; sub ( /\.nrx/,".java",$$1 ) ; print $$1 }' | xargs rm -f
	rm -rf build



