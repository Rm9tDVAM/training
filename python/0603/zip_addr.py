"""
import zip_addr
print(zip_addr.get_addr('144-0054'))

result
東京都大田区新蒲田
"""
def get_addr(addr):
    import urllib.request as req
    import json
    #url="https://api.aoikujira.com/zip/zip.php?zn=144-0054&fmt=json"
    url="https://api.aoikujira.com/zip/zip.php?zn="
    url+=str(addr)+"&fmt=json"
    res=req.urlopen(url)
    json_data=res.read()
    data=json.loads(json_data)
    #print(data['result'])
    return data['result']

