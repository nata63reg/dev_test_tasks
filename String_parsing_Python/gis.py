import re
import json

def string_pars(file):

	ro = open(file, 'r')
	string=ro.read()
	ro.close()

	print('Input string: ',string)
	cnt=0
	str1=''
	length=len(string)

	for i in string:
		str1+=i
		if i=='|':
			cnt+=1
		if cnt==7:
			res1=len(str1)
			break

	s1=string[0:res1-1]
	s2=string[res1+1:length]

	s1=s1.split('|')

	slovar={}
	cnt=0
	for i in s1:
		cnt+=1
		slovar["param"+str(cnt)]=i

	r1=s2.split(' ')
	r2=''
	regexp=''
	for i in r1:
		r2+=i.replace('=',':',1)+' '

	keys = re.findall(r'(\w+):', r2)

	for k in keys:
		regexp+=k+':(.*) '

	values = re.match(regexp, r2)

	cnt=1
	for j in keys:
		slovar[j]=values.group(cnt)
		cnt+=1


	#Out to file
	print('Output string: ',slovar)
	rw=open('out.log','w')
	rw.write(json.dumps(slovar))
	rw.close()

def main():

	str=string_pars('input.log')

	
if __name__ == '__main__':
	main()
