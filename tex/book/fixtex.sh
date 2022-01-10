sudo dpkg --purge --force-depends texlive-lang-other texlive-latex-extra tex-common texlive-fonts-recommended texlive-pictures texlive-metapost
sudo apt-get install -f texlive-lang-other texlive-latex-extra tex-common texlive-fonts-recommended texlive-pictures texlive-metapost
sudo mktexlsr
sudo updmap-sys
