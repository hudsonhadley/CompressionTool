# CompressionTool #
This project is a personal endeavor after a long drought of not knowing what to code.
A thanks to [John Crickett](https://www.linkedin.com/in/johncrickett/) for this idea.
John makes great coding challenges for people like me who want to code something, but
don't know exactly what to do. The original challenge for this can be seen
[here](https://codingchallenges.fyi/challenges/challenge-huffman/).

This project was a learning experience when it came to understanding compression
algorithms. I had never worked with binary files or conversion from Strings to bytes,
so some of the logic behind that may be a bit muddled compared to others who have worked
with those things before.

It also taught me the importance of fully fleshing out classes
before writing them and the importance of having a full plan before writing. Implementing stubs
and putting javadoc and figuring out how classes will interact with each other before you write
is such an advantage. Knowing where you are going before you start driving is incredibly
valuable as a programmer.

Lastly, TDD (test driven development) is always great as I learned through
this. Perhaps it does not need to happen for each class, but for the more complex ones, you
should have a clear idea of what each class ought to do.

There are a decent amount of classes here so let's unpack:
* [Compressor](src/Compressor.java) - Compresses a file
* [Decompressor](src/Decompressor.java) - Decompresses a file
* [FileComparison](src/FileComparison.java) - Compresses and decompresses a file and compares it to the original. Useful
for determining if the compression was lossy
* [FrequencyTable](src/FrequencyTable.java) - Stores a frequency table of how often a set of characters each appears
* [FrequencyTableTest](src/FrequencyTableTest.java) - Some small test code to make sure FrequencyTable is working properly
* [HuffmanBinaryTree](src/HuffmanBinaryTree.java) - Stores a [Huffman binary tree](https://en.wikipedia.org/wiki/Huffman_coding)
that is used to determine what binary codes are for what characters
* [HuffmanInternalNode](src/HuffmanInternalNode.java) - [Huffman binary trees](src/HuffmanBinaryTree.java) have nodes and leaves. Nodes do not correspond
to a character, but are a bridge between two characters
* [HuffmanLeaf](src/HuffmanLeaf.java) - Leaves correspond to characters and their frequencies in the tree
* [Main](src/Main.java) - Where the compression/decompression occurs. This can be accessed through command line arguments
* [Node](src/Node.java) - A parent class for the [HuffmanInternalNode](src/HuffmanInternalNode.java) and the
[HuffmanLeaf](src/HuffmanLeaf.java)
* [PrefixCodeTable](src/PrefixCodeTable.java) - A lookup to determine what codes correspond to what characters
* [PrefixCodeTableTest](src/PrefixCodeTableTest.java) - Some simple tests to make sure PrefixCodeTable is working properly

Finally, this algorithm can be used with any text file (or really any file at that). The text file for Victor Hugo's 
[Les Misérables](lesMiserables.txt) is provided (originally from 
[Project Gutenberg](https://www.gutenberg.org/files/135/135-0.txt)) for testing. It can reasonably be assumed that if it
works for a text file of this magnitude with so many special characters, it will most likely work for almost any file.
I received almost a 50% reduction in size when I ran the algorithm of the Les Misérables text file.