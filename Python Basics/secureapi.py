import os
import requests
from dotenv import load_dotenv
from pathlib import Path

env_path = Path(__file__).parent / ".env"
load_dotenv(env_path)

load_dotenv()

api_key = os.getenv("GITHUB_TOKEN")

print("Token loaded:", api_key is not None)

headers = {
    "Authorization": f"Bearer {api_key}",
    "Accept": "application/vnd.github+json",
    "User-Agent": "python-requests",
}

response = requests.get("https://api.github.com/user", headers=headers, timeout=10)

response.raise_for_status()
print("Token loaded:", os.getenv("GITHUB_TOKEN") is not None)

print(response.json())
