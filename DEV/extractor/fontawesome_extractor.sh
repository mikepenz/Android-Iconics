#!/bin/sh

URL="https://fortawesome.github.io/Font-Awesome/cheatsheet/"
PATTERN_VALUE="&#x([0-9a-zA-Z]+)"
PATTERN_KEY="(fa-[a-zA-Z0-9_-]+)"

curl -silent "$URL" | sed -En "
	# Look for the value pattern
	/$PATTERN_VALUE/ {
		# If found, read the next line
		N
		# Look for the key pattern
		/$PATTERN_KEY/ {
			# If found, print the formated key/value pair
			s/.*$PATTERN_VALUE.*\n.*$PATTERN_KEY.*/\2('\\\u\1'),/
			# Replace '-' by '_' in order to have proper enum name
			s/-/_/g
			# Only print these results
			p
		}
	}" | sort



#**
# * Copyright 2013 Joan Zapata
 #*
 #* Licensed under the Apache License, Version 2.0 (the "License");
 #* you may not use this file except in compliance with the License.
 #* You may obtain a copy of the License at
 #*
 #*     http://www.apache.org/licenses/LICENSE-2.0
 #*
 #* Unless required by applicable law or agreed to in writing, software
 #* distributed under the License is distributed on an "AS IS" BASIS,
 #* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 #* See the License for the specific language governing permissions and
 #* limitations under the License.
 #*/
