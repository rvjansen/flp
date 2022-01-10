#!/usr/share/python
# -*- encoding: utf-8 -*-
#
# Download the portuguese wordnet
# Clean it up a little
#
import codecs
import urllib2
wnlang = "por"
url  =  "https://github.com/arademaker/wordnet-br/raw/master/wn-data-por.tab"


outfile = "wn-data-%s.tab" % wnlang
out = codecs.open(outfile, "w", "utf-8" )

for l in urllib2.urlopen(url).read().decode('utf-8').split('\n'):
    if l.startswith (u'#'):
        out.write(l + '\n')
    else:
        things = l.strip().split("\t")
        if len(things) == 3:
            (synset, kind, lemma) = l.strip().split("\t")
            lemma = lemma.replace(u'_', u' ')
            lemma = lemma.strip(u'"')  ### was losing these, but decided to keep them
            out.write("%s\t%s\t%s\n" % (synset, kind, lemma))
