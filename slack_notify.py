import json
import requests
import sys

def send_slack_notification(message, webhook_url):
    payload = {
        "text": message
    }
    headers = {'Content-Type': 'application/json'}

    response = requests.post(webhook_url, data=json.dumps(payload), headers=headers)

    if response.status_code != 200:
        print(f"Failed to send message: {response.status_code} - {response.text}")
        sys.exit(1)
    else:
        print("Notification sent to Slack successfully.")

if __name__ == "__main__":
    # Example usage
    message = "✅ Build completed successfully!"
    webhook_url = "https://hooks.slack.com/services/XXX/YYY/ZZZ"  # Replace with your actual webhook
    send_slack_notification(message, webhook_url)
