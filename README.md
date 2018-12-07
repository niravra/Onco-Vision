# Onco-Vision
ANALYSIS OF CANCER SOMATIC MUTATION USING BIG DATA PATTERN

## Problem Statement
**Somatic Cells**

An alteration in DNA that occurs after conception. Somatic mutations can occur in any of the cells of the body except the germ cells (sperm and egg) and therefore are not passed on to children. These alterations can (but do not always) cause cancer or other diseases

As Cancer is one of the most common reasons of death and the medical society is still finding cure to the gene mutations causing cancer. The Analysis in this report with the cosmic dataset will help the researchers to focus on the important portions of the disease and figure out the mutation points for drug testing.

## Dataset

**Catalogue of Somatic Mutations in Cancer(Cosmic) Mutation Data**

COSMIC, the Catalogue of Somatic Mutations in Cancer, is the world's largest and most comprehensive resource for exploring the impact of somatic mutations in human cancer.

Website Link - https://cancer.sanger.ac.uk/cosmic

**ANALYSIS 1**
Highest affected site of cancer in human body
Counting pattern is used on the respective field

**ANALYSIS 2**
Most Common CDS Length for mutation
Inverted Pattern and Job Chaining is used for matching the CDS Length of genes with their respective groups and a comparison is also made between the mutated data and the normal data

**ANALYSIS 3**
Mutation location of the genes for performing drug trials
The analysis is performed using distinct pattern, join patterns and job chaining. Left Outer Join is used to map the somatic genes with the mutated genes and the location of the genes is mapped

**ANALYSIS 4**
Mapping of the cancer site, affected genes based on mutation and the frequency of each genes.
The analysis is done using the custom key writable and using hashmap to store in memory counter of the gene data.

**ANALYSIS 5**
Analysis of data to look for the most common type of the abnormalities in the genes that will help in drug testing phase using job chaining

**ANALYSIS 6**
Use of Apache Mahout for the Artificial Intelligence of predicting the related cancer type, User Recommender
The TSV file is cleansed, custom key and partitioning are used for creating the data in the format of USERID, ITEMID, where USERID represents the cancer and the ITEMID represents the genes responsible for that cancer.

**ANALYSIS 7**
Use of bloom filtering for filtering out the data removing the false positives
