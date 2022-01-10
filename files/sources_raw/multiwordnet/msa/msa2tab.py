#!/usr/share/python
# -*- encoding: utf-8 -*-
#
# Extract synset-word pairs from the Wordnet Bahasa
# Creates two wordnets (Malay: zsm, and Indonesian: ind)
#

import sys
import codecs
#import re

wndata= "/home/bond/svn/wn-msa/tab/"

wnname = "Wordnet Bahasa" 
wnlangm = "zsm"
wnlangi = "ind"
wnurl = "http://wn-msa.sourceforge.net/"
wnlicense = "MIT"

#
# header
#
outfile = "wn-data-%s.tab" % wnlangm
om = codecs.open(outfile, "w", "utf-8" )
om.write("# %s\t%s\t%s\t%s \n" % (wnname, wnlangm, wnurl, wnlicense))

outfile = "wn-data-%s.tab" % wnlangi
oi = codecs.open(outfile, "w", "utf-8" )
oi.write("# %s\t%s\t%s\t%s \n" % (wnname, wnlangi, wnurl, wnlicense))

#
# Data is in the file wn-msa-all.tab
# synset\tlang\tgoodness\tlemma

f = codecs.open(wndata + "wn-msa-all.tab", "rb", "utf-8" )

#synset = str()
#lemma = str()
for l in f:
    (synset, lng, status, lemma) = l.strip().split("\t")
    if status in ['Y', 'O' ]:  # can I make this a set
        if lng == 'B':
            oi.write("%s\t%s:lemma\t%s\n" % (synset, wnlangi, lemma))
            om.write("%s\t%s:lemma\t%s\n" % (synset, wnlangm, lemma))
        elif lng == 'I':
            oi.write("%s\t%s:lemma\t%s\n" % (synset, wnlangi, lemma))
        elif lng == 'M':
            om.write("%s\t%s:lemma\t%s\n" % (synset, wnlangm, lemma))
        ##print "%s\t%s\n" % (synset, lemma)
