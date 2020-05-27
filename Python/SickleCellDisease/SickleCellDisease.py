"""
Task 25
Create a program called, ‘SickleCellDisease.py’. You will simulate the effects of the
Single Nucleotide Polymorphism that leads to this genetic disease.
@Author: Yolisa Pingilili
"""
# dictionary copied from Ta Odz
AminoAcids = {"ATT": "I", "ATC": "I", "ATA": "I",

              "CTT": "L", "CTC": "L", "CTA": "L", "CTG": "L", "TTA": "L", "TTG": "L",

              "GTT": "V", "GTC": "V", "GTA": "V", "GTG": "V",

              "TTT": "F", "TTC": "F", "ACA": "V",

              "ATG": "M",
              # REPLACE ALL THE OTHER LETTERS UNDER HERE WITH 'X' INSTEAD OF 'C, A, G, P, T, S, Y, '
              "TGT": "X", "TGC": "X",

              "GCT": "X", "GCC": "X", "GCA": "X", "GCG": "X",

              "GGT": "X", "GGC": "X", "GGA": "X", "GGG": "X",

              "CCT": "X", "CCC": "X", "CCA": "X", "CCG": "X",

              "ACT": "X", "TCG": "X", "AGT": "X", "AGC": "X",

              "TCT": "X", "TCC": "X", "TCA": "X", "TAT": "X", "TAC": "X",

              "TGG": "X",

              "CAA": "X", "CAG": "X",

              "AAT": "X", "AAC": "X",

              "CAT": "X", "CAC": "X",

              "GAA": "X", "GAG": "X",

              "GAT": "X", "GAC": "X",

              "AAA": "X", "AAG": "X",

              "CGT": "X", "CGC": "X", "CGA": "X", "CGG": "X", "AGA": "X", "AGG": "X",

              "TAA": "X", "TAG": "X", "TGA": "X", "ACG": "X", "ACC": "X"
              }


def translate(Sequence):
    """
    function ‘translate’ that, when given a DNA sequence of arbitrary length,
    the program identifies and returns the amino acid sequence of the DNA using the
    amino acid SLC code found in that table

    :param Sequence: The DNA Sequence to be translated
    :return: "translatedString", Amino acids that correspond with the DNA string.
    """
    translatedString = ""
    if len(Sequence) % 3 != 0:
        return "invalid length of DNA sequence, length should be 3 or a multiple of 3."
    else:
        for i in range(0, len(Sequence), 3):
            translatedString = AminoAcids[Sequence[i:i+3]] + translatedString
        return translatedString

# print(translate("ATTATTATT"))

def mutate():
    """
    This function
    must read the contents of the text file named 'DNA.txt'. It must then identify the first
    occurrence of the lowercase letter 'a' in 'DNA.txt'.
    Then replace it with 'A' and write the output to file 'normalDNA.txt'
    Then replace it with 'T' and write the output to file 'mutatedDNA.txt'

    :return: two text files
    """
    file = open('DNA.txt', 'r')
    DNAFileData = file.read()

    normalDNAFile = open("normalDNA.txt", "w+")
    normalDNAFile.write(DNAFileData.replace("a", "A"))
    #
    mutatedDNAFile = open("mutatedDNA.txt", "w+")
    mutatedDNAFile.write(DNAFileData.replace("a", "T"))
    #
    file.close()
    normalDNAFile.close()
    mutatedDNAFile.close()
mutate()


def txtTranslate(inputFile):
    """
    ‘txtTranslate’, that calls the 'translate' function that you
    wrote in Task 1, to take in text file input.
    Call it on both mutatedDNA.txt and normalDNA.txt, and output both Amino Acid
    sequences to the user.

    :param inputFile: text file containing a DNA sequence
    :return: output corresponding amino acid sequence to the user
    """
    try:
        contents = ""
        file = open(inputFile)
        inputFileData = file.read()
        inputFileData = inputFileData.replace("\n", "")
        for line in inputFileData:
            contents += line
        file.close()
        return translate(contents)
    except FileNotFoundError:
        print("The file is not in this folder.")
    finally:
        pass

print(txtTranslate("normalDNA.txt"))
print(txtTranslate("mutatedDNA.txt"))
