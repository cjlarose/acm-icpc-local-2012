#!/usr/bin/env python
import sys
import os.path
import subprocess

working_dir = os.path.abspath(os.path.join(__file__, os.path.pardir))

if len(sys.argv) < 2:
	print "Usage ./test.py [Classname]"
else:
	classname = sys.argv[1]
	print "Do test " + classname

	i = 1
	while (True):
		input_file = "test/%s.in" % (classname.lower() + str(i))
		output_file = "test/out/%s.out" % (classname.lower() + str(i))
		correct_output_file = "test/%s.out" % (classname.lower() + str(i))

		if not os.path.exists(os.path.abspath(input_file)):
			break

		cmd = "java -cp '%s' %s < %s > %s" % (os.path.join(working_dir, 'bin'), classname, input_file, output_file)
		subprocess.call(cmd, shell=True)

		cmd = "diff %s %s" % (output_file, correct_output_file)
		p = subprocess.Popen(cmd, stdout=subprocess.PIPE, shell=True)

		out, err = p.communicate()

		if len(out) == 0:
			print "Test %s passed! You're awesome!" % str(i)
		else:
			print "Test %s failed! You can do better!" % (str(i))
			print out

		i = i + 1
