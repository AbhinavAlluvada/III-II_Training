import time
requests = {}
LIMIT = 5
TIME_WINDOW = 60
def is_allowed(user_id):
    current_time = time.time()
    if user_id not in requests:
        requests[user_id] = []
        
    requests[user_id] = [
        t for t in requests[user_id]
        if current_time -t < TIME_WINDOW
    ]
    if len(requests[user_id])<LIMIT:
        requests[user_id].append(current_time)
        return True
    else:
        return False