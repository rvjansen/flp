#makefile for book
TARGET		:= book
PDFTARGET	:= $(TARGET).pdf
TEX_SRC		:= $(wildcard *.tex)
BIB_SRC		:= $(wildcard *.bib)
LATEX_EXE	:= xelatex -shell-esc
RAIL_EXE	:= rail

.SUFFIXES: .nrx .nry .njp .class .skel .xsl .java .pdf


all:	$(PDFTARGET)

$(TARGET).pdf: $(TEX_SRC)
	$(MAKE) -k $(TARGET).bbl
	$(LATEX_EXE) $(TARGET).tex
#	$(RAIL_EXE) $(TARGET)
	@while ( grep "There were undefined references." $(TARGET).log >/dev/null ); do \
		echo '** Re-running pdfLaTeX **'; \
		$(LATEX_EXE) $(TARGET).tex; \
		makeindex $(TARGET); \
	done
	mv book.pdf "Papiamento.pdf"

$(TARGET).bbl: $(TEXSRC) $(BIBSRC)
	$(LATEX_EXE) $(TARGET).tex
	bibtex $(TARGET)
	makeindex $(TARGET)

#
# target clean removes compiled products
#
.PHONY: clean
clean: 
	rm -f *.class
	rm -f *.crossref
	rm -f *.aux
	rm -f *~
	rm -f *.idx
	rm -f *.ilg
	rm -f *.ind
	rm -f *.log
	rm -f *.lof
	rm -f *.lol
	rm -f *.lot
	rm -f *.out
	rm -f *.toc
	rm -f *.pdf

static:
	$(LATEX_EXE) static.tex
#	$(RAIL_EXE) static
	@while ( grep "There were undefined references." $(TARGET).log >/dev/null ); do \
		echo '** Re-running pdfLaTeX **'; \
		$(LATEX_EXE) static.tex; \
		makeindex static; \
	done


