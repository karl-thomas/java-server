provider "aws" {
  profile = "default"
  region  = "us-east-1"
}

variable "server_port" {
  description = "The port the server will use for requests"
  default     = 7777
}

resource "aws_security_group" "websg" {
  name = "java-server-websg"
  ingress {
    from_port   = "${var.server_port}"
    to_port     = "${var.server_port}"
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }
  ingress {
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

resource "aws_instance" "webserver" {
  ami                    = "ami-3508e54f"
  instance_type          = "t2.micro"
  key_name               = "deploy-server"
  vpc_security_group_ids = ["${aws_security_group.websg.id}"]

  tags = {
    Name = "java-server"
  }
}
