import pandas as pd
import numpy as np
from matplotlib import pyplot as plt
import seaborn as sns
df = pd.read_csv('Без имени 2.csv',sep=';')
a = pd.DataFrame()
for i in df['<DATE>'].unique():
    b = df[df['<DATE>']==i].reset_index(drop=True)
    b = b[['<OPEN>','<HIGH>','<LOW>','<CLOSE>']]
    b.rename(columns={"<OPEN>":"ОТКРЫТИЕ","<HIGH>":"МАКС","<LOW>":"МИН","<CLOSE>":"ЗАКРЫТИЕ"},inplace=True)
    b=b.astype(np.float32)
    cols = []
    for j in b.columns:
        cols += [i+'-'+j]
    b.columns = cols
    a = pd.concat((a,b),axis=1)
plt.figure(figsize=(10,6))
sns.boxplot(data=a)
plt.show()