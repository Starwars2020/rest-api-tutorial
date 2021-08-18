app-build:
	./gradlew clean build && java -jar ./build/libs/rest-api-tutorial-0.1.0.jar
docker-env:
	eval $$(minikube docker-env)
	kubectl port-forward --namespace kube-system $$(kubectl get po -n kube-system | grep kube-registry-v0 | awk '{print $$1;}') 5000:5000 &
docker-build:
	docker build -t localhost:5000/rest-api-tutorial:1.0 .
	docker images localhost:5000/rest-api-tutorial:1.0
	docker push localhost:5000/rest-api-tutorial:1.0
	@echo "\n"
create:
	@kubectl create -f rest-api-tutorial-deployment.yaml
	@kubectl create -f rest-api-tutorial-service.yaml
	@kubectl create -f rest-api-tutorial-ingress.yaml
	@echo "\n"
delete:
	@kubectl delete -f rest-api-tutorial-deployment.yaml
	@kubectl delete -f rest-api-tutorial-service.yaml
	@kubectl delete -f rest-api-tutorial-ingress.yaml
	@echo "\n"
admission:
	kubectl delete validatingwebhookconfiguration ingress-nginx-admission
kong-env:
	kubectl port-forward -n kong svc/kong-control-plane 8001:8001 &
	kubectl port-forward -n kong svc/kong-ingress-data-plane 8000:8000 &
kong-test-env:
	curl -i -X POST --url http://localhost:8001/services/ --data 'name=test-service' --data 'url=http://rest-sample.info/greeting'
	curl -i -X POST --url http://localhost:8001/services/test-service/routes --data 'hosts[]=test.com'
	curl -i -X POST http://localhost:8001/services/test-service/plugins --data name=rate-limiting --data config.minute=3 --data config.policy=local
	curl -i -X POST --url http://localhost:8001/consumers/ --data "username=test"
	curl -i -X POST --url http://localhost:8001/consumers/test/key-auth/ --data 'key=test'
	curl -i -X POST --url http://localhost:8001/services/test-service/plugins/ --data 'name=key-auth'
