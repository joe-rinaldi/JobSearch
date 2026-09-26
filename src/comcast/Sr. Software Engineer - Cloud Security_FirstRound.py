# “We want to detect brute-force login attempts. 
# You get a list of login events. 
# Each event is [timestamp, user, success] — a time in seconds, a username, and whether the login succeeded.

# When someone is hammering an account with failures, we want to start blocking their attempts. Write a function that returns the attempts that should be blocked.”

# 1. A user is locked out once they hit 3 failed logins within a 30-second window. Those 3 failures go through; the next attempt (4th onward) is what gets blocked.

# 2. While locked out, every attempt is blocked — even one with the correct password — and a blocked attempt changes nothing.

# 3. A successful login that is not blocked resets that user’s failure count to zero. (Each user is tracked independently.)

# # Example 1 — basic lockout
# events = [[1,"billy",False],[5,"billy",False],[15,"billy",False],[25,"billy",False]]
# # -> [(25, "billy")]
# # 3 failures at t=1,5,15 fill the window; the 4th attempt at t=25 is blocked.

# # Example 2 — window expiry (failures age out)
# events = [[1,"billy",False],[5,"billy",False],[15,"billy",False],[50,"billy",False]]
# # -> []
# # By t=50 the failures at t=1 and t=5 are older than 30s, so only 2 remain. No block.





#create loginAttempst List 
# timestamp, user, failedCount, NextAction
#iterrate list of events 
# each event[username] == false add username with failed attempts  to loginttempts 

#LoginWhiteList
#iterate thru the loginAttempst
#loginAttempst[username] = 'Allow'
# if loginAttempst[timest] > 3  loginAttempst['loginAction'] = 'Deny'


#UserCanLogin
#iterate thru the Events
# 
# if events[timestamp] > loginAttempst['loginAction'] = 'Deny'

