#!/usr/share/python
# -*- encoding: utf-8 -*-
#
# Extract synset-word pairs from the Japanese Wordnet
#

import sys
import codecs
#import re

wndata="/home/bond/svn/wnja-code/tab/"
wnname = "Japanese Wordnet" 
wnlang = "jpn"
wnurl = "http://nlpwww.nict.go.jp/wn-ja/"
wnlicense = "wordnet"

#
# header
#
outfile = "wn-data-%s.tab" % wnlang
o = codecs.open(outfile, "w", "utf-8" )

o.write("# %s\t%s\t%s\t%s \n" % (wnname, wnlang, wnurl, wnlicense))

#
# Data is in the file wnjpn-all.tab
# offset<TAB>Japanese<TAB>Status

f = codecs.open(wndata + "wnjpn-all.tab", "rb", "utf-8" )

sysnset = str()
lemma = str()
for l in f:
    (synset, lemma, status) = l.strip().split("\t")
    if status in ['hand', 'mlsn', 'mono', 'multi' ]:
        o.write("%s\tlemma\t%s\n" % (synset, lemma))
        ##print "%s\t%s\n" % (synset, lemma)
